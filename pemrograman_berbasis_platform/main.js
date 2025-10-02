function price_after_discount(price) {
  const rp = new Intl.NumberFormat('id-ID', {
    style: 'currency',
    currency: 'IDR',
    minimumFractionDigits: 2
  }).format(price)

  let final_price;
  price > 1000000 ?
    final_price = price - (price * (15 / 100)) : price > 500000 ?
      final_price = price - (price * (10 / 100)) : final_price = price

  console.log(`
    diskon 10% jika total belanja anda > Rp 500.000
    diskon 15% jika total belanja anda > Rp 1.000.000
    `);

  const tagihan = new Intl.NumberFormat('id-ID', {
    style: 'currency',
    currency: 'IDR',
    minimumFractionDigits: 2
  }).format(final_price)

  price > 1000000 ?
    console.log(`
    Total belanjaan anda: ${rp}
    
    Yeay dapet diskon 15%
      harga normal: \x1b[9m${rp}\x1b[0m
      harga diskon: ${tagihan}
    `) :
    price > 500000 ?
      console.log(`
    Total belanjaan anda: ${rp}
    
    Yeay dapet diskon 10%
      harga normal: \x1b[9m${rp}\x1b[0m
      harga diskon: ${tagihan}
      `) : console.log(`
    Total belanjaan anda: ${rp}

    Belanjanya yang banyak dong,
    biar dapet diskon!!
      harga: ${tagihan}
        `)
}
const price = price_after_discount(622200)


