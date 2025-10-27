"""
Fungsi untuk analisis galat relatif.
"""

def actual_value_from_relative_error(approx: float, rel_error_percent: float) -> float:
    """
    Hitung nilai aktual dari pendekatan bila galat relatif r (%) diketahui.

    Formula yang dipakai: r = |x_true - x_approx| / x_true
    Dengan asumsi tanda sehingga x_true = x_approx / (1 - r).

    Parameters
    - approx: nilai pendekatan (float)
    - rel_error_percent: galat relatif dalam persen (float)

    Returns
    - float: estimasi nilai aktual

    Raises
    - ValueError jika rel_error_percent >= 100
    """
    r = rel_error_percent / 100.0
    if r >= 1.0:
        raise ValueError("relative error must be less than 100 percent")
    return approx / (1 - r)
