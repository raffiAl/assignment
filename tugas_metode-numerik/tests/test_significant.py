from metode_numerik.significant import significant_figures_area

def test_area_rounding():
    area, sf, rounded = significant_figures_area(12.345, 'cm', 0.034, 'm', sf_length=5, sf_width=2)
    assert sf == 2
    assert round(area, 7) == round(0.12345 * 0.034, 7)
    assert rounded != 0
