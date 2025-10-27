from metode_numerik.maclaurin import maclaurin_exp_order3
import math

def test_maclaurin():
    x = 0.2
    approx = maclaurin_exp_order3(x)
    assert abs(approx - (1 + x + x**2/2 + x**3/6)) < 1e-12
    assert approx != math.exp(x)
