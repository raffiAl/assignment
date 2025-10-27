"""
Aproksimasi deret Maclaurin untuk e^x.
"""

import math

def maclaurin_exp_order3(x: float) -> float:
    """
    Aproksimasi e^x hingga orde 3:
      e^x ≈ 1 + x + x^2/2! + x^3/3!

    Parameters
    - x: float

    Returns
    - float: aproksimasi e^x
    """
    return 1.0 + x + (x**2)/math.factorial(2) + (x**3)/math.factorial(3)
