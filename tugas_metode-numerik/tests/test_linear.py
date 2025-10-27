from metode_numerik.linear import is_strictly_diagonally_dominant
import pytest

def test_diagonal_dominant_true():
    A = [
        [4, -1, 1],
        [1, 3, -1],
        [1, -1, 5]
    ]
    assert is_strictly_diagonally_dominant(A) is True

def test_non_square():
    A = [[1,2,3],[4,5,6]]
    with pytest.raises(ValueError):
        is_strictly_diagonally_dominant(A)
