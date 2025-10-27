"""
Plotting helpers untuk metode_numerik.

Fungsi:
- plot_table(x, fx, filename=None) : plot f(x) terhadap x, simpan ke filename jika diberikan.
- plot_convergence(xs, ys, filename=None) : plot error atau iterasi konvergensi, simpan jika filename diberikan.

Modul ini men-set backend matplotlib non-interaktif jika environment tidak menyediakan display.
"""
from typing import Iterable, Optional
import matplotlib
import os

# gunakan backend non-interaktif saat DISPLAY tidak tersedia (headless)
if not os.environ.get("DISPLAY"):
    matplotlib.use("Agg")

import matplotlib.pyplot as plt

def plot_table(xs: Iterable[float], fxs: Iterable[float], filename: Optional[str] = None) -> None:
    """
    Plot f(x) terhadap x dan simpan/atau tampilkan.
    - xs: urutan x
    - fxs: urutan f(x) sesuai xs
    - filename: jika diberikan, simpan PNG ke path ini; jika None, tampilkan (jika GUI tersedia)
    """
    plt.figure(figsize=(6,4))
    plt.plot(list(xs), list(fxs), marker='o', linestyle='-')
    plt.axhline(0, color='gray', linewidth=0.8)
    plt.xlabel("x")
    plt.ylabel("f(x)")
    plt.title("Plot f(x) vs x")
    plt.grid(True)
    if filename:
        plt.tight_layout()
        plt.savefig(filename)
        plt.close()
    else:
        plt.show()

def plot_convergence(xs: Iterable[float], ys: Iterable[float], filename: Optional[str] = None) -> None:
    """
    Plot perubahan nilai (mis. error) terhadap iterasi atau langkah.
    - xs: sumbu x (iterasi atau langkah)
    - ys: nilai error atau nilai yang dikurangkan terhadap true value
    - filename: jika diberikan, simpan; jika None, tampilkan
    """
    plt.figure(figsize=(6,4))
    plt.semilogy(list(xs), [abs(v) for v in ys], marker='o')
    plt.xlabel("Iteration / Step")
    plt.ylabel("Absolute error (log scale)")
    plt.title("Convergence / Error plot")
    plt.grid(True, which="both", ls="--")
    if filename:
        plt.tight_layout()
        plt.savefig(filename)
        plt.close()
    else:
        plt.show()
