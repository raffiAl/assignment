from metode_numerik.error import actual_value_from_relative_error
import pytest

def test_actual_value():
    actual = actual_value_from_relative_error(97, 3)
    assert pytest.approx(actual, rel=1e-9) == 97 / 0.97
