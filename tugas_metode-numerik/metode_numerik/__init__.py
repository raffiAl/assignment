"""
metode_numerik package

Ekspor fungsi-fungsi utama untuk tugas metode numerik.
"""
from .significant import significant_figures_area, round_sigfig
from .error import actual_value_from_relative_error
from .maclaurin import maclaurin_exp_order3
from .linear import is_strictly_diagonally_dominant
from .table_method import table_method_intervals
from .fixed_point import fixed_point_g, fixed_point_iteration
