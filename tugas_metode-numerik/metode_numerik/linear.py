"""
Cek konvergensi iteratif sistem linear via dominansi diagonal.
"""

from typing import List

def is_strictly_diagonally_dominant(A: List[List[float]]) -> bool:
    """
    Periksa apakah matriks A bersifat strictly diagonally dominant.

    Parameters
    - A: list of list, matriks persegi

    Returns
    - True jika |a_ii| > sum_{j!=i} |a_ij| untuk semua i, False otherwise

    Raises
    - ValueError jika A tidak persegi
    """
    n = len(A)
    if any(len(row) != n for row in A):
        raise ValueError("Matrix A must be square")
    for i in range(n):
        diag = abs(A[i][i])
        off_sum = sum(abs(A[i][j]) for j in range(n) if j != i)
        if not (diag > off_sum):
            return False
    return True
