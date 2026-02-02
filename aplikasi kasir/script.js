class KasirCafeRidho {
  constructor() {
    this.cart = [];
    this.transactions = [];
    this.products = this.generateProducts();
    this.currentTransactionId = this.generateTransactionId();
    this.init();
  }

  generateTransactionId() {
    const date = new Date();
    const day = String(date.getDate()).padStart(2, "0");
    const hour = String(date.getHours()).padStart(2, "0");
    const minute = String(date.getMinutes()).padStart(2, "0");
    const second = String(date.getSeconds()).padStart(2, "0");
    return `TRX${day}${hour}${minute}${second}`;
  }

  generateProducts() {
    return [
      {
        id: 1,
        name: "Nasi Goreng Special",
        category: "food",
        price: 25000,
        description: "Nasi goreng dengan telur dan ayam",
        icon: "fas fa-utensils",
        color: "#FF6B6B",
      },
      {
        id: 2,
        name: "Mie Ayam Bakso",
        category: "food",
        price: 20000,
        description: "Mie ayam dengan bakso spesial",
        icon: "fas fa-bowl-food",
        color: "#4ECDC4",
      },
      {
        id: 3,
        name: "Ayam Goreng Kremes",
        category: "food",
        price: 22000,
        description: "Ayam goreng dengan kremes renyah",
        icon: "fas fa-drumstick-bite",
        color: "#FFD166",
      },
      {
        id: 4,
        name: "Soto Ayam",
        category: "food",
        price: 18000,
        description: "Soto ayam dengan kuah kaldu",
        icon: "fas fa-bowl-rice",
        color: "#06D6A0",
      },
      {
        id: 5,
        name: "Es Teh Manis",
        category: "drink",
        price: 5000,
        description: "Es teh dengan gula pasir",
        icon: "fas fa-glass-water",
        color: "#118AB2",
      },
      {
        id: 6,
        name: "Es Jeruk",
        category: "drink",
        price: 8000,
        description: "Es jeruk segar",
        icon: "fas fa-glass-water-droplet",
        color: "#FF9E6D",
      },
      {
        id: 7,
        name: "Kopi Hitam",
        category: "drink",
        price: 10000,
        description: "Kopi arabika pilihan",
        icon: "fas fa-mug-hot",
        color: "#6D6875",
      },
      {
        id: 8,
        name: "Cappuccino",
        category: "drink",
        price: 15000,
        description: "Cappuccino dengan busa susu",
        icon: "fas fa-mug-saucer",
        color: "#B5838D",
      },
      {
        id: 9,
        name: "Kentang Goreng",
        category: "snack",
        price: 12000,
        description: "Kentang goreng renyah",
        icon: "fas fa-french-fries",
        color: "#FFB703",
      },
      {
        id: 10,
        name: "Singkong Keju",
        category: "snack",
        price: 15000,
        description: "Singkong goreng dengan keju",
        icon: "fas fa-cheese",
        color: "#FB8500",
      },
      {
        id: 11,
        name: "Brownies",
        category: "dessert",
        price: 10000,
        description: "Brownies coklat lezat",
        icon: "fas fa-cake-candles",
        color: "#8B4513",
      },
      {
        id: 12,
        name: "Pudding Caramel",
        category: "dessert",
        price: 8000,
        description: "Pudding dengan saus caramel",
        icon: "fas fa-ice-cream",
        color: "#DDA15E",
      },
      {
        id: 13,
        name: "Roti Bakar",
        category: "snack",
        price: 12000,
        description: "Roti bakar dengan meses",
        icon: "fas fa-bread-slice",
        color: "#E9C46A",
      },
      {
        id: 14,
        name: "Milkshake Coklat",
        category: "drink",
        price: 18000,
        description: "Milkshake coklat kental",
        icon: "fas fa-whiskey-glass",
        color: "#7B3F00",
      },
      {
        id: 15,
        name: "Salad Buah",
        category: "dessert",
        price: 15000,
        description: "Salad buah segar",
        icon: "fas fa-apple-whole",
        color: "#FF6B6B",
      },
    ];
  }

  init() {
    this.setupEventListeners();
    this.renderProducts();
    this.updateDateTime();
    this.updateAIStats();
    this.setupAutoSave();
    setInterval(() => this.updateDateTime(), 1000);
    setInterval(() => this.updateAIStats(), 30000);
  }

  setupEventListeners() {
    document
      .getElementById("product-search")
      .addEventListener("input", (e) => this.filterProducts(e.target.value));

    document.querySelectorAll(".cat-btn").forEach((btn) => {
      btn.addEventListener("click", (e) => {
        const category = e.currentTarget.dataset.category;
        this.filterByCategory(category, e.currentTarget);
      });
    });

    document
      .getElementById("clear-cart")
      .addEventListener("click", () => this.clearCart());
    document
      .getElementById("calculate-btn")
      .addEventListener("click", () => this.calculateChange());
    document
      .getElementById("pay-btn")
      .addEventListener("click", () => this.processPayment());
    document
      .getElementById("discount")
      .addEventListener("input", () => this.updateCartSummary());
    document
      .getElementById("cash-amount")
      .addEventListener("input", () => this.calculateChange());

    document.querySelectorAll(".pay-btn").forEach((btn) => {
      btn.addEventListener("click", (e) =>
        this.selectPaymentMethod(
          e.currentTarget.dataset.method,
          e.currentTarget,
        ),
      );
    });

    document
      .getElementById("close-receipt")
      .addEventListener("click", () => this.closeReceipt());
    document
      .getElementById("print-btn")
      .addEventListener("click", () => window.print());

    const mobileBtn = document.querySelector(".mobile-menu-btn");
    if (mobileBtn) {
      mobileBtn.addEventListener("click", () => this.toggleMobileMenu());
    }

    document.addEventListener("click", (e) => {
      if (
        e.target.closest(".add-btn") ||
        e.target.classList.contains("add-btn")
      ) {
        e.stopPropagation();
        const productCard = e.target.closest(".product-card");
        if (productCard) {
          const productId = parseInt(productCard.dataset.id);
          this.addToCart(productId);
        }
      }

      if (
        e.target.closest(".product-card") &&
        !e.target.classList.contains("add-btn")
      ) {
        const productCard = e.target.closest(".product-card");
        const productId = parseInt(productCard.dataset.id);
        this.addToCart(productId);
      }
    });
  }

  filterProducts(searchTerm) {
    const filtered = this.products.filter(
      (product) =>
        product.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
        product.description.toLowerCase().includes(searchTerm.toLowerCase()),
    );
    this.renderProducts(filtered);
  }

  filterByCategory(category, button) {
    document
      .querySelectorAll(".cat-btn")
      .forEach((btn) => btn.classList.remove("active"));
    button.classList.add("active");

    const filtered =
      category === "all"
        ? this.products
        : this.products.filter((product) => product.category === category);
    this.renderProducts(filtered);
  }

  renderProducts(products = this.products) {
    const container = document.getElementById("products-grid");
    container.innerHTML = products
      .map(
        (product) => `
            <div class="product-card" data-id="${product.id}">
                <div class="product-image" style="background: linear-gradient(135deg, ${product.color}20, ${product.color}40)">
                    <i class="${product.icon}" style="color: ${product.color}"></i>
                </div>
                <div class="product-info">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <div class="product-price">
                        <span class="price">Rp ${product.price.toLocaleString("id-ID")}</span>
                        <button class="add-btn" data-id="${product.id}">
                            <i class="fas fa-plus"></i>
                        </button>
                    </div>
                </div>
            </div>
        `,
      )
      .join("");
  }

  addToCart(productId) {
    const product = this.products.find((p) => p.id === productId);
    if (!product) return;

    const existingItem = this.cart.find((item) => item.id === productId);

    if (existingItem) {
      existingItem.quantity += 1;
    } else {
      this.cart.push({
        ...product,
        quantity: 1,
      });
    }

    this.showNotification(
      "success",
      "Berhasil!",
      `${product.name} ditambahkan ke keranjang`,
    );
    this.renderCart();
    this.updateCartSummary();
    this.updateAIStats();

    this.animateAddToCart(productId);
  }

  animateAddToCart(productId) {
    const productCard = document.querySelector(
      `.product-card[data-id="${productId}"]`,
    );
    const addBtn = document.querySelector(`.add-btn[data-id="${productId}"]`);

    if (productCard && addBtn) {
      addBtn.innerHTML = '<i class="fas fa-check"></i>';
      addBtn.style.background = "#06D6A0";

      setTimeout(() => {
        addBtn.innerHTML = '<i class="fas fa-plus"></i>';
        addBtn.style.background = "";
      }, 500);

      productCard.style.transform = "scale(0.95)";
      setTimeout(() => {
        productCard.style.transform = "";
      }, 300);
    }
  }

  removeFromCart(productId) {
    this.cart = this.cart.filter((item) => item.id !== productId);
    this.renderCart();
    this.updateCartSummary();
    this.showNotification("warning", "Dihapus", "Item dihapus dari keranjang");
  }

  updateQuantity(productId, delta) {
    const item = this.cart.find((item) => item.id === productId);
    if (item) {
      item.quantity += delta;
      if (item.quantity < 1) {
        this.removeFromCart(productId);
        return;
      }
      this.renderCart();
      this.updateCartSummary();
    }
  }

  renderCart() {
    const container = document.getElementById("cart-items");
    const countElement = document.getElementById("cart-count");

    if (this.cart.length === 0) {
      container.innerHTML = `
                <div class="empty-state">
                    <i class="fas fa-cart-arrow-down"></i>
                    <p>Keranjang kosong</p>
                    <small>Pilih menu dari kiri</small>
                </div>
            `;
      countElement.textContent = "0 item";
      return;
    }

    container.innerHTML = this.cart
      .map(
        (item) => `
            <div class="cart-item">
                <div class="item-info">
                    <h4>${item.name}</h4>
                    <div class="item-price">Rp ${(item.price * item.quantity).toLocaleString("id-ID")}</div>
                </div>
                <div class="item-controls">
                    <button class="qty-btn" onclick="kasir.updateQuantity(${item.id}, -1)">-</button>
                    <span class="item-qty">${item.quantity}</span>
                    <button class="qty-btn" onclick="kasir.updateQuantity(${item.id}, 1)">+</button>
                    <button class="remove-btn" onclick="kasir.removeFromCart(${item.id})">
                        <i class="fas fa-times"></i>
                    </button>
                </div>
            </div>
        `,
      )
      .join("");

    countElement.textContent = `${this.cart.reduce((sum, item) => sum + item.quantity, 0)} item`;
  }

  updateCartSummary() {
    const subtotal = this.cart.reduce(
      (sum, item) => sum + item.price * item.quantity,
      0,
    );
    const discount = parseInt(document.getElementById("discount").value) || 0;
    const discountAmount = subtotal * (discount / 100);
    const subtotalAfterDiscount = subtotal - discountAmount;
    const tax = subtotalAfterDiscount * 0.1;
    const total = subtotalAfterDiscount + tax;

    document.getElementById("subtotal").textContent =
      `Rp ${subtotal.toLocaleString("id-ID")}`;
    document.getElementById("tax").textContent =
      `Rp ${tax.toLocaleString("id-ID")}`;
    document.getElementById("total").textContent =
      `Rp ${total.toLocaleString("id-ID")}`;

    this.updateTodayStats();
    this.saveToLocalStorage();
  }

  calculateChange() {
    const totalText = document.getElementById("total").textContent;
    const total = parseInt(totalText.replace(/[^0-9]/g, "")) || 0;
    const cashGiven =
      parseFloat(document.getElementById("cash-amount").value) || 0;
    const change = cashGiven - total;

    const changeElement = document.getElementById("change-amount");
    if (change >= 0) {
      changeElement.textContent = `Rp ${change.toLocaleString("id-ID")}`;
      changeElement.style.color = "#06D6A0";
      changeElement.classList.add("positive");
      changeElement.classList.remove("negative");
    } else {
      changeElement.textContent = `-Rp ${Math.abs(change).toLocaleString("id-ID")}`;
      changeElement.style.color = "#EF476F";
      changeElement.classList.add("negative");
      changeElement.classList.remove("positive");
    }
  }

  selectPaymentMethod(method, button) {
    document
      .querySelectorAll(".pay-btn")
      .forEach((btn) => btn.classList.remove("active"));
    button.classList.add("active");

    const suggestions = {
      cash: "💰 Pembayaran tunai dipilih. Siapkan uang kembalian.",
      qris: "📱 Scan QRIS untuk pembayaran. Pastikan internet stabil.",
      edc: "💳 Gesek kartu untuk pembayaran. Tunggu konfirmasi.",
      ovo: "📲 Bayar dengan OVO/DANA. Scan QR code.",
    };

    this.updateAISuggestion(
      suggestions[method] || "✅ Metode pembayaran dipilih.",
    );
  }

  processPayment() {
    if (this.cart.length === 0) {
      this.showNotification("error", "Gagal!", "Keranjang belanja kosong");
      return;
    }

    const total = this.getTotalAmount();
    const cashGiven =
      parseFloat(document.getElementById("cash-amount").value) || 0;
    const selectedMethod =
      document.querySelector(".pay-btn.active").dataset.method;

    if (selectedMethod === "cash" && cashGiven < total) {
      this.showNotification(
        "error",
        "Uang Kurang!",
        `Uang kurang Rp ${(total - cashGiven).toLocaleString("id-ID")}`,
      );
      return;
    }

    const transaction = {
      id: this.currentTransactionId,
      items: [...this.cart],
      total: total,
      time: new Date().toLocaleString("id-ID"),
      paymentMethod: selectedMethod,
      cashGiven: cashGiven,
      change: cashGiven - total,
    };

    this.transactions.push(transaction);
    this.showNotification(
      "success",
      "✅ Berhasil!",
      `Transaksi ${this.currentTransactionId} selesai`,
    );

    setTimeout(() => {
      this.showReceipt(transaction);
      this.clearCart();
      this.currentTransactionId = this.generateTransactionId();
      this.updateAIStats();
    }, 500);
  }

  showReceipt(transaction) {
    const modal = document.getElementById("receipt-modal");
    const receiptDate = document.getElementById("receipt-time");
    const receiptItems = document.getElementById("receipt-items");
    const receiptTotal = document.getElementById("receipt-total");

    receiptDate.textContent = transaction.time;

    const itemsHTML = transaction.items
      .map(
        (item) => `
            <div class="receipt-item">
                <span>${item.name} x${item.quantity}</span>
                <span>Rp ${(item.price * item.quantity).toLocaleString("id-ID")}</span>
            </div>
        `,
      )
      .join("");

    receiptItems.innerHTML = itemsHTML;

    const subtotal = transaction.items.reduce(
      (sum, item) => sum + item.price * item.quantity,
      0,
    );
    const discount = parseInt(document.getElementById("discount").value) || 0;
    const discountAmount = subtotal * (discount / 100);
    const subtotalAfterDiscount = subtotal - discountAmount;
    const tax = subtotalAfterDiscount * 0.1;
    const total = subtotalAfterDiscount + tax;

    receiptTotal.innerHTML = `
            <div class="receipt-total-row">
                <span>Subtotal</span>
                <span>Rp ${subtotal.toLocaleString("id-ID")}</span>
            </div>
            ${
              discount > 0
                ? `
            <div class="receipt-total-row">
                <span>Diskon ${discount}%</span>
                <span>-Rp ${discountAmount.toLocaleString("id-ID")}</span>
            </div>
            `
                : ""
            }
            <div class="receipt-total-row">
                <span>PPN 10%</span>
                <span>Rp ${tax.toLocaleString("id-ID")}</span>
            </div>
            <div class="receipt-total-row">
                <span>Metode Bayar</span>
                <span>${this.getPaymentMethodName(transaction.paymentMethod)}</span>
            </div>
            ${
              transaction.paymentMethod === "cash"
                ? `
            <div class="receipt-total-row">
                <span>Uang Diberikan</span>
                <span>Rp ${transaction.cashGiven.toLocaleString("id-ID")}</span>
            </div>
            <div class="receipt-total-row">
                <span>Kembalian</span>
                <span>Rp ${transaction.change.toLocaleString("id-ID")}</span>
            </div>
            `
                : ""
            }
            <div class="receipt-total-row total">
                <span>TOTAL</span>
                <span>Rp ${total.toLocaleString("id-ID")}</span>
            </div>
        `;

    modal.style.display = "flex";
    document.body.style.overflow = "hidden";
  }

  getPaymentMethodName(method) {
    const methods = {
      cash: "Tunai",
      qris: "QRIS",
      edc: "Kartu",
      ovo: "E-Wallet",
    };
    return methods[method] || method;
  }

  closeReceipt() {
    const modal = document.getElementById("receipt-modal");
    modal.style.display = "none";
    document.body.style.overflow = "auto";
  }

  getTotalAmount() {
    const totalText = document.getElementById("total").textContent;
    return parseInt(totalText.replace(/[^0-9]/g, "")) || 0;
  }

  clearCart() {
    this.cart = [];
    document.getElementById("cash-amount").value = "";
    document.getElementById("discount").value = "0";
    document.getElementById("cash-amount").dispatchEvent(new Event("input"));
    this.renderCart();
    this.updateCartSummary();
  }

  updateDateTime() {
    const now = new Date();
    document.getElementById("current-time").textContent =
      now.toLocaleTimeString("id-ID");
    document.getElementById("current-date").textContent =
      now.toLocaleDateString("id-ID", {
        weekday: "long",
        year: "numeric",
        month: "long",
        day: "numeric",
      });
  }

  updateTodayStats() {
    const todayTransactions = this.transactions.filter((t) => {
      const transDate = new Date(t.time);
      const today = new Date();
      return transDate.toDateString() === today.toDateString();
    });

    const todayRevenue = todayTransactions.reduce((sum, t) => sum + t.total, 0);
    const todayItems = todayTransactions.reduce(
      (sum, t) =>
        sum + t.items.reduce((itemSum, item) => itemSum + item.quantity, 0),
      0,
    );

    document.getElementById("today-transactions").textContent =
      todayTransactions.length;
    document.getElementById("today-revenue").textContent =
      `Rp ${todayRevenue.toLocaleString("id-ID")}`;
  }

  updateAIStats() {
    const topProduct = this.getTopProduct();
    const prediction = this.generatePrediction();

    document.getElementById("top-product").textContent = topProduct;
    document.getElementById("prediction").textContent =
      `Rp ${prediction.toLocaleString("id-ID")}`;

    const suggestions = [
      `🔥 Rekomendasikan ${topProduct} - produk terlaris hari ini!`,
      `📊 Prediksi penjualan: Rp ${prediction.toLocaleString("id-ID")}`,
      `🎯 Berikan diskon 5% untuk meningkatkan penjualan 15%`,
      `⏰ Waktu sibuk: 12:00-14:00 & 18:00-20:00`,
      `⚠️ Stok ${topProduct} menipis, pertimbangkan restok`,
      `💡 Kombinasikan minuman dengan snack untuk upselling`,
      `🌟 Pelanggan loyal dapat diskon khusus 10%`,
      `📈 Penjualan meningkat ${Math.floor(Math.random() * 20) + 5}% dari kemarin`,
    ];

    const randomSuggestion =
      suggestions[Math.floor(Math.random() * suggestions.length)];
    this.updateAISuggestion(randomSuggestion);
  }

  getTopProduct() {
    if (this.transactions.length === 0) return "Nasi Goreng Special";

    const productCounts = {};
    this.transactions.forEach((trans) => {
      trans.items.forEach((item) => {
        productCounts[item.name] =
          (productCounts[item.name] || 0) + item.quantity;
      });
    });

    const topProduct = Object.entries(productCounts).sort(
      (a, b) => b[1] - a[1],
    )[0];
    return topProduct ? topProduct[0] : "Nasi Goreng Special";
  }

  generatePrediction() {
    const now = new Date();
    const hour = now.getHours();
    const day = now.getDay();

    let base = 500000;

    if (day === 0 || day === 6) base = 800000;

    if (hour >= 11 && hour <= 14) base *= 1.6;
    if (hour >= 17 && hour <= 20) base *= 2.4;

    const randomFactor = 0.8 + Math.random() * 0.4;
    const actualSales = this.transactions
      .filter((t) => new Date(t.time).toDateString() === now.toDateString())
      .reduce((sum, t) => sum + t.total, 0);

    return Math.round(Math.max(base * randomFactor, actualSales * 1.2));
  }

  updateAISuggestion(message) {
    const aiElement = document.getElementById("ai-suggestion");
    aiElement.innerHTML = `<p>${message}</p>`;

    aiElement.style.animation = "none";
    setTimeout(() => {
      aiElement.style.animation = "pulse 2s";
    }, 10);
  }

  showNotification(type, title, message) {
    const container = document.getElementById("notifications");
    const notification = document.createElement("div");
    notification.className = `notification ${type}`;
    notification.innerHTML = `
            <h4>${title}</h4>
            <p>${message}</p>
        `;

    notification.style.animation = "slideInRight 0.3s";
    container.appendChild(notification);

    setTimeout(() => {
      notification.style.animation = "slideInRight 0.3s reverse";
      setTimeout(() => notification.remove(), 300);
    }, 3000);
  }

  toggleMobileMenu() {
    const leftPanel = document.querySelector(".left-panel");
    if (window.innerWidth <= 768) {
      leftPanel.style.display =
        leftPanel.style.display === "none" ? "flex" : "none";
    }
  }

  setupAutoSave() {
    window.addEventListener("beforeunload", () => {
      this.saveToLocalStorage();
    });

    const saved = localStorage.getItem("cafeRidhoData");
    if (saved) {
      try {
        const data = JSON.parse(saved);
        this.transactions = data.transactions || [];
        this.updateTodayStats();
        this.updateAIStats();
      } catch (e) {
        console.log("Gagal memuat data tersimpan");
      }
    }
  }

  saveToLocalStorage() {
    const data = {
      transactions: this.transactions,
      lastSave: new Date().toISOString(),
    };
    localStorage.setItem("cafeRidhoData", JSON.stringify(data));
  }
}

const kasir = new KasirCafeRidho();

const style = document.createElement("style");
style.textContent = `
    @keyframes pulse {
        0% { transform: scale(1); }
        50% { transform: scale(1.02); }
        100% { transform: scale(1); }
    }
    
    .positive { color: #06D6A0 !important; }
    .negative { color: #EF476F !important; }
`;
document.head.appendChild(style);
