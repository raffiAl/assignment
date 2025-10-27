"""
Utility functions untuk pembulatan dan helper numerik.
"""

import math

def round_sigfig(x: float, sigfigs: int) -> float:
    """
    Bulatkan bilangan x ke jumlah angka penting sigfigs.

    Parameters
    - x: float, nilai yang akan dibulatkan
    - sigfigs: int, jumlah angka penting (>0)

    Returns
    - float: nilai x dibulatkan ke sigfigs angka penting

    Raises
    - ValueError jika sigfigs <= 0
    """
    if sigfigs <= 0:
        raise ValueError("sigfigs must be positive")
    if x == 0:
        return 0.0
    power = math.floor(math.log10(abs(x)))
    factor = 10 ** (power - sigfigs + 1)
    return round(x / factor) * factor
