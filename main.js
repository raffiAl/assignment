// Deklarasi variable
const math = 80;
const english = 95;
const ipa = 80;

// perhitungan nilai rata-rata
const nilai_ratarata = (math + english + ipa)/3;

// output&type
console.log(nilai_ratarata)
console.log(typeof(nilai_ratarata))

// condition
if(nilai_ratarata >= 80) {
  console.log('LULUS')
} else {
  console.log('TIDAK LULUS')
}