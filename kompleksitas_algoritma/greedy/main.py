def greedy_coin_change(amount, coins):
    # Urutkan koin dari besar ke kecil
    coins.sort(reverse=True)
    
    result = {}
    total_coins = 0
    
    for coin in coins:
        if amount >= coin:
            count = amount // coin   # berapa banyak koin ini dipakai
            amount -= count * coin   # kurangi jumlah uang
            result[coin] = count
            total_coins += count
    
    return result, total_coins

# --- Program utama ---
# Input jumlah uang
amount = int(input("Masukkan jumlah uang: "))

# Input daftar koin (dipisahkan spasi)
coins = list(map(int, input("Masukkan daftar nilai koin (pisahkan dengan spasi): ").split()))

# Jalankan algoritma greedy
result, total_coins = greedy_coin_change(amount, coins)

# Tampilkan hasil
print("\nKombinasi koin yang digunakan:")
for coin, count in result.items():
    print(f"{coin} x {count}")

print(f"\nJumlah total koin: {total_coins}")
