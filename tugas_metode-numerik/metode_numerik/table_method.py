"""
Metode tabel untuk menemukan interval akar berdasarkan perubahan tanda f(x).
"""

from typing import Callable, List, Tuple

def table_method_intervals(f: Callable[[float], float],
                           x_start: float, x_end: float, step: float
                           ) -> Tuple[List[Tuple[float, float]], List[Tuple[float, float]]]:
    """
    Buat tabel (x, f(x)) pada rentang [x_start, x_end] dengan langkah step,
    lalu kembalikan daftar interval [a,b] di mana f(a)*f(b) < 0.

    Parameters
    - f: callable, fungsi f(x)
    - x_start, x_end: float, batas
    - step: float > 0

    Returns
    - table: list of (x, f(x))
    - intervals: list of (a, b) (a==b jika f(a)==0)
    """
    if step <= 0:
        raise ValueError("step must be positive")
    xs = []
    n_steps = int(round((x_end - x_start) / step))
    for i in range(n_steps + 1):
        xi = x_start + i * step
        xs.append(round(xi, 12))
    table = [(xi, f(xi)) for xi in xs]
    intervals = []
    for i in range(len(table) - 1):
        x0, f0 = table[i]
        x1, f1 = table[i + 1]
        if f0 == 0:
            intervals.append((x0, x0))
        elif f0 * f1 < 0:
            intervals.append((x0, x1))
    return table, intervals
