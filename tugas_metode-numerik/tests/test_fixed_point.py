from metode_numerik.fixed_point import fixed_point_iteration, fixed_point_g

def test_fixed_point():
    root, iters = fixed_point_iteration(fixed_point_g, x0=0.5, tol=1e-10, max_iter=1000)
    assert abs(root**3 + root - 1) < 1e-6
