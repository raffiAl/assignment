"""
Perhitungan terkait angka penting dan konversi satuan.
"""

from .utils import round_sigfig
from typing import Tuple

def significant_figures_area(length_value: float, length_unit: str,
                             width_value: float, width_unit: str,
                             sf_length: int, sf_width: int) -> Tuple[float, int, float]:
    """
    Hitung luas persegi panjang (dalam m^2) dan bulatkan hasil sesuai angka penting terkecil.

    Parameters
    - length_value: nilai panjang (float)
    - length_unit: 'm' atau 'cm'
    - width_value: nilai lebar (float)
    - width_unit: 'm' atau 'cm'
    - sf_length: angka penting panjang (int)
    - sf_width: angka penting lebar (int)

    Returns
    - area_m2: luas tanpa pembulatan (float)
    - sf_min: angka penting yang digunakan untuk pembulatan (int)
    - area_rounded: luas dibulatkan sesuai sf_min (float)
    """
    def to_m(value: float, unit: str) -> float:
        unit = unit.lower()
        if unit == 'm':
            return value
        if unit == 'cm':
            return value / 100.0
        raise ValueError("Unit must be 'm' or 'cm'")

    L_m = to_m(length_value, length_unit)
    W_m = to_m(width_value, width_unit)
    area_m2 = L_m * W_m
    sf_min = min(int(sf_length), int(sf_width))
    area_rounded = round_sigfig(area_m2, sf_min)
    return area_m2, sf_min, area_rounded
