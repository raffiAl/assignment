from metode_numerik.table_method import table_method_intervals

def f(x): return x**3 - 4*x + 1

def test_table_intervals():
    table, intervals = table_method_intervals(f, -2, 2, 0.5)
    assert len(table) > 0
    assert any(a < b for a,b in intervals)
