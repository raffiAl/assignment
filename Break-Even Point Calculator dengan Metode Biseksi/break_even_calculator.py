def break_even_bisection(fixed_cost, variable_cost, selling_price, a, b, tol=1e-6, max_iter=1000):
    """
    MENGHITUNG TITIK IMPAS PERUSAHAAN MENGGUNAKAN METODE BISEKSI
    
    Parameters:
    -----------
    fixed_cost : float
        Biaya tetap perusahaan (dalam Rupiah)
    variable_cost : float
        Biaya variabel per unit (dalam Rupiah)
    selling_price : float
        Harga jual per unit (dalam Rupiah)
    a : float
        Batas bawah interval tebakan quantity
    b : float
        Batas atas interval tebakan quantity
    tol : float, optional
        Toleransi error (default: 1e-6)
    max_iter : int, optional
        Maksimum iterasi (default: 1000)
    
    Returns:
    --------
    dict
        Dictionary berisi hasil perhitungan dan metadata
    """
    
    # FUNGSI PROFIT: f(Q) = (Selling Price - Variable Cost) * Q - Fixed Cost
    def profit_function(Q):
        return (selling_price - variable_cost) * Q - fixed_cost
    
    # VALIDASI INTERVAL AWAL
    fa = profit_function(a)
    fb = profit_function(b)
    
    if fa * fb >= 0:
        raise ValueError(f"Interval [{a}, {b}] tidak valid (Perlebar Interval, ln 187). f({a}) = {fa:,.0f}, f({b}) = {fb:,.0f}. Harus berbeda tanda.")
    
    print("=" * 60)
    print("PERHITUNGAN TITIK IMPAS METODE BISEKSI")
    print("=" * 60)
    print(f"Biaya Tetap: Rp {fixed_cost:,.0f}")
    print(f"Biaya Variabel per unit: Rp {variable_cost:,.0f}")
    print(f"Harga Jual per unit: Rp {selling_price:,.0f}")
    print(f"Margin per unit: Rp {selling_price - variable_cost:,.0f}")
    print(f"Interval awal: [{a}, {b}] unit")
    print(f"Toleransi: {tol}")
    print("-" * 60)
    
    # INISIALISASI VARIABEL ITERASI
    iteration = 0
    current_a = a
    current_b = b
    history = []  # Untuk melacak progres konvergensi
    
    # ITERASI BISEKSI
    for iteration in range(1, max_iter + 1):
        # TITIK TENGAH
        c = (current_a + current_b) / 2
        fc = profit_function(c)
        
        # SIMPAN PROGRES
        history.append({
            'iterasi': iteration,
            'a': current_a,
            'b': current_b,
            'c': c,
            'f(c)': fc,
            'lebar_interval': current_b - current_a
        })
        
        # CEK KONVERGENSI
        if abs(fc) < tol or (current_b - current_a) / 2 < tol:
            print(f"✨ Konvergen dicapai pada iterasi ke-{iteration}")
            break
        
        # UPDATE INTERVAL
        if fa * fc < 0:
            current_b = c
            fb = fc
        else:
            current_a = c
            fa = fc
    else:
        print(f"⚠️  Maksimum iterasi ({max_iter}) tercapai tanpa konvergensi penuh")
    
    return {
        'break_even_point': c,
        'profit_at_solution': fc,
        'iterations': iteration,
        'convergence_history': history,
        'required_units': round(c),  # Pembulatan ke unit terdekat
        'total_revenue': selling_price * c,
        'total_cost': fixed_cost + variable_cost * c
    }


def display_results(results):
    """
    MENAMPILKAN HASIL PERHITUNGAN DALAM FORMAT YANG USER-FRIENDLY
    
    Parameters:
    -----------
    results : dict
        Hasil perhitungan dari fungsi break_even_bisection
    """
    
    print("\n" + "=" * 60)
    print("HASIL PERHITUNGAN TITIK IMPAS")
    print("=" * 60)
    
    bep = results['break_even_point']
    units = results['required_units']
    
    print(f"📍 Titik Impas (BEP): {bep:,.2f} unit")
    print(f"📍 Pembulatan praktis: {units:,} unit")
    print(f"💰 Total Pendapatan: Rp {results['total_revenue']:,.0f}")
    print(f"💸 Total Biaya: Rp {results['total_cost']:,.0f}")
    print(f"📊 Profit pada solusi: Rp {results['profit_at_solution']:,.2f}")
    print(f"🔄 Jumlah iterasi: {results['iterations']}")
    
    # TAMPILKAN 5 ITERASI TERAKHIR UNTUK MELIHAT KONVERGENSI
    print("\n" + "-" * 60)
    print("PROGRES KONVERGENSI (5 iterasi terakhir):")
    print("-" * 60)
    print("Iter | Quantity (c) | Profit f(c)    | Lebar Interval")
    print("-" * 60)
    
    history = results['convergence_history']
    for step in history[-5:]:
        print(f"{step['iterasi']:4} | {step['c']:12.6f} | {step['f(c)']:13.6f} | {step['lebar_interval']:13.6f}")


def analyze_business_implications(results, fixed_cost, variable_cost, selling_price):
    """
    ANALISIS IMPLIKASI BISNIS DARI HASIL PERHITUNGAN
    
    Parameters:
    -----------
    results : dict
        Hasil perhitungan break-even
    fixed_cost : float
        Biaya tetap
    variable_cost : float
        Biaya variabel per unit
    selling_price : float
        Harga jual per unit
    """
    
    bep = results['required_units']
    margin = selling_price - variable_cost
    margin_percentage = (margin / selling_price) * 100
    
    print("\n" + "=" * 60)
    print("ANALISIS BISNIS")
    print("=" * 60)
    print(f"🔍 Margin Kontribusi: Rp {margin:,.0f} ({margin_percentage:.1f}%)")
    print(f"📈 Rasio Biaya Tetap/Margin: {fixed_cost / margin:.2f}")
    
    # ANALISIS SENSITIVITAS
    print("\n💡 REKOMENDASI STRATEGIS:")
    if bep > 1000:
        print("   - Titik impas cukup tinggi, pertimbangkan:")
        print("     * Menurunkan biaya variabel")
        print("     * Meningkatkan harga jual")
        print("     * Menurunkan biaya tetap")
    else:
        print("   - Titik impas realistis, fokus pada:")
        print("     * Meningkatkan volume penjualan")
        print("     * Ekspansi pasar")
    
    print(f"   - Setiap penjualan di atas {bep:,} unit akan memberikan")
    print(f"     profit Rp {margin:,.0f} per unit")


# MAIN EXECUTION
if __name__ == "__main__":
    try:
        # PARAMETER BISNIS
        FIXED_COST = 25000000      # Rp 25 juta (sewa, gaji, dll)
        VARIABLE_COST = 8000       # Rp 8.000 (bahan per cup)
        SELLING_PRICE = 25000      # Rp 25.000 per cup
        
        # TEBAKAN INTERVAL AWAL (dengan analisis kasar)
        # f(0) = -50.000.000 (rugi), f(500) = 150.000×500 - 50.000.000 = 25.000.000 (untung)
        A = 0
        B = 5000
        
        # EKSEKUSI PERHITUNGAN
        results = break_even_bisection(
            fixed_cost=FIXED_COST,
            variable_cost=VARIABLE_COST,
            selling_price=SELLING_PRICE,
            a=A, b=B,
            tol=1e-6,
            max_iter=100
        )
        
        # TAMPILKAN HASIL
        display_results(results)
        analyze_business_implications(results, FIXED_COST, VARIABLE_COST, SELLING_PRICE)
        
        print("\n" + "🎯 " + "="*50 + " 🎯")
        print(f"KESIMPULAN: Perusahaan perlu menjual {results['required_units']:,} unit")
        print("untuk mencapai titik impas (tidak untung tidak rugi)")
        print("🎯 " + "="*50 + " 🎯")
        
    except Exception as e:
        print(f"❌ Error: {e}")
    except KeyboardInterrupt:
        print("\n⚠️  Program dihentikan oleh user")