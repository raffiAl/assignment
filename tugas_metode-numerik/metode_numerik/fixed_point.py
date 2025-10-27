"""
Metode titik tetap untuk contoh x^3 + x - 1 = 0
"""

from typing import Callable, Tuple

def fixed_point_g(x: float) -> float:
    """
    Contoh fungsi iterasi g(x) = (1 - x)^(1/3).
    Pastikan domain dan cabang akar sesuai implementasi yang diinginkan.
    """
    return (1 - x) ** (1.0 / 3.0)

def fixed_point_iteration(g: Callable[[float], float],
                          x0: float,
                          tol: float = 1e-8,
                          max_iter: int = 1000) -> Tuple[float, int]:
    """
    Iterasi titik tetap.

    Parameters
    - g: fungsi iterasi
    - x0: tebakan awal
    - tol: toleransi konvergensi (default 1e-8)
    - max_iter: batas iterasi

    Returns
    - (x_approx, iter_count)
    """
    x = x0
    for k in range(1, max_iter + 1):
        x_new = g(x)
        if abs(x_new - x) < tol:
            return x_new, k
        x = x_new
    return x, max_iter
