#!/usr/bin/env python3
"""
CLI untuk paket metode_numerik.

Subcommands:
- area        : hitung luas dengan angka penting
- maclaurin   : aproksimasi e^x orde 3
- error       : hitung nilai aktual dari galat relatif
- table       : buat tabel f(x) dan temukan interval akar, optional --plot
- fixed-point : iterasi titik tetap, optional --plot untuk konvergensi

Contoh:
  python cli.py area --length 12.345 --lunit cm --width 0.034 --wunit m --sfl 5 --sfw 2
  python cli.py table --start -2 --end 2 --step 0.5 --plot --out table.png
"""
import argparse
import sys
from typing import List

from metode_numerik.significant import significant_figures_area
from metode_numerik.maclaurin import maclaurin_exp_order3
from metode_numerik.error import actual_value_from_relative_error
from metode_numerik.table_method import table_method_intervals
from metode_numerik.fixed_point import fixed_point_iteration, fixed_point_g
from metode_numerik import plotting
from metode_numerik.linear import is_strictly_diagonally_dominant


def cmd_area(args):
    try:
        area, sf, rounded = significant_figures_area(
            args.length, args.lunit, args.width, args.wunit, args.sfl, args.sfw
        )
    except Exception as e:
        print("Error:", e, file=sys.stderr)
        sys.exit(2)
    print(f"Luas (tanpa pembulatan): {area} m^2")
    print(f"Angka penting dipakai: {sf}")
    print(f"Luas (dibulatkan): {rounded} m^2")

# handler untuk subcommand "linear"
def cmd_linear(args):
    try:
        # A diinput sebagai string JSON-like, mis: "[[4,-1,1],[1,3,-1],[1,-1,5]]"
        import ast
        A = ast.literal_eval(args.matrix)
        ok = is_strictly_diagonally_dominant(A)
    except Exception as e:
        print("Error:", e, file=sys.stderr)
        sys.exit(2)
    print("Matrix is strictly diagonally dominant:" , ok)


def cmd_maclaurin(args):
    val = maclaurin_exp_order3(args.x)
    print(f"Maclaurin e^{args.x} (orde 3) ≈ {val}")

def cmd_error(args):
    try:
        actual = actual_value_from_relative_error(args.approx, args.rel)
    except Exception as e:
        print("Error:", e, file=sys.stderr)
        sys.exit(2)
    print(f"Nilai aktual (perkiraan): {actual}")

def cmd_table(args):
    def f(x): return eval(args.expr, {"x": x, "__builtins__": {} })
    try:
        table, intervals = table_method_intervals(f, args.start, args.end, args.step)
    except Exception as e:
        print("Error:", e, file=sys.stderr)
        sys.exit(2)
    print("Tabel nilai (x, f(x)):")
    for xi, fxi in table:
        print(f"  x={xi:.6g}, f(x)={fxi:.6g}")
    if intervals:
        print("Interval yang mengandung akar:")
        for a,b in intervals:
            if a == b:
                print(f"  Akar tepat di x = {a}")
            else:
                print(f"  [{a}, {b}]")
    else:
        print("  Tidak ditemukan perubahan tanda pada interval yang diberikan.")
    if args.plot:
        xs = [t[0] for t in table]
        fxs = [t[1] for t in table]
        out = args.out or "table_plot.png"
        plotting.plot_table(xs, fxs, filename=out)
        print(f"Plot disimpan ke {out}")

def cmd_fixed_point(args):
    g = fixed_point_g if args.g is None else None
    if args.g is not None:
        # Jika user memberikan ekspresi g(x), buat fungsi aman sederhana
        def g_local(x):
            return eval(args.g, {"x": x, "__builtins__": {} })
        g = g_local
    try:
        root, iters = fixed_point_iteration(g, args.x0, tol=args.tol, max_iter=args.maxiter)
    except Exception as e:
        print("Error:", e, file=sys.stderr)
        sys.exit(2)
    print(f"Akar pendekatan: {root} (iterasi: {iters})")
    if args.plot:
        # untuk plotting konvergensi, jalankan iterasi manual dan catat error terhadap tiap langkah
        xs = []
        ys = []
        x = args.x0
        for k in range(1, args.maxiter+1):
            x_new = g(x)
            xs.append(k)
            ys.append(x_new - x)
            if abs(x_new - x) < args.tol:
                break
            x = x_new
        out = args.out or "fixed_point_convergence.png"
        plotting.plot_convergence(xs, ys, filename=out)
        print(f"Plot konvergensi disimpan ke {out}")

def build_parser() -> argparse.ArgumentParser:
    p = argparse.ArgumentParser(prog="metode_numerik")
    sub = p.add_subparsers(dest="cmd", required=True)

    a = sub.add_parser("area", help="Hitung luas dengan angka penting")
    a.add_argument("--length", type=float, required=True)
    a.add_argument("--lunit", choices=["m","cm"], default="m")
    a.add_argument("--width", type=float, required=True)
    a.add_argument("--wunit", choices=["m","cm"], default="m")
    a.add_argument("--sfl", type=int, required=True, dest="sfl")
    a.add_argument("--sfw", type=int, required=True, dest="sfw")
    a.set_defaults(func=cmd_area)

    m = sub.add_parser("maclaurin", help="Aproksimasi e^x orde 3")
    m.add_argument("x", type=float)
    m.set_defaults(func=cmd_maclaurin)

    e = sub.add_parser("error", help="Hitung nilai aktual dari galat relatif")
    e.add_argument("--approx", type=float, required=True)
    e.add_argument("--rel", type=float, required=True, help="galat relatif dalam persen")
    e.set_defaults(func=cmd_error)

    t = sub.add_parser("table", help="Metode tabel; default fungsi x**3 - 4*x + 1")
    t.add_argument("--start", type=float, required=True)
    t.add_argument("--end", type=float, required=True)
    t.add_argument("--step", type=float, required=True)
    t.add_argument("--expr", type=str, default="x**3 - 4*x + 1", help="ekspresi fungsi dalam variabel x")
    t.add_argument("--plot", action="store_true", help="simpan plot f(x) ke file")
    t.add_argument("--out", type=str, default=None, help="nama file output plot (PNG)")
    t.set_defaults(func=cmd_table)

    fp = sub.add_parser("fixed-point", help="Iterasi titik tetap")
    fp.add_argument("--x0", type=float, required=True, help="tebakan awal")
    fp.add_argument("--tol", type=float, default=1e-8)
    fp.add_argument("--maxiter", type=int, default=1000)
    fp.add_argument("--g", type=str, default=None, help="opsional: ekspresi g(x) sebagai string, mis. '(1-x)**(1/3)'")
    fp.add_argument("--plot", action="store_true", help="simpan plot konvergensi")
    fp.add_argument("--out", type=str, default=None, help="nama file output plot (PNG)")
    fp.set_defaults(func=cmd_fixed_point)

    ln = sub.add_parser("linear", help="Cek strict diagonal dominance untuk matriks persegi")
    ln.add_argument("--matrix", type=str, required=True,
                    help='Matriks dalam format Python list, mis: "[[4,-1,1],[1,3,-1],[1,-1,5]]"')
    ln.set_defaults(func=cmd_linear)
    
    return p

def main(argv: List[str] = None):
    p = build_parser()
    args = p.parse_args(argv)
    args.func(args)

if __name__ == "__main__":
    main()
