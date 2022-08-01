class App {
    static DOMAIN = location.origin;

    static BASE_URL_AUTH = this.DOMAIN + "/api/auth";
    static BASE_URL_BOOK = this.DOMAIN + "/api/books";

    static ERROR_400 = "Giao dịch không thành công, vui lòng kiểm tra lại dữ liệu.";
    static ERROR_401 = "Access Denied! Invalid credentials.";
    static ERROR_403 = "Access Denied! You are not authorized to perform this function.";
    static ERROR_404 = "An error occurred. Please try again later!";
    static ERROR_500 = "Lưu dữ liệu không thành công, vui lòng liên hệ quản trị hệ thống.";
    static SUCCESS_CREATED = "Successful data generation !";
    static SUCCESS_UPDATED = "Data update successful !";

    static SUCCESS_SUSPEND = "Succeeded client suspension !";

    static SweetAlert = class {
        static showSuccessAlert(t) {
            Swal.fire({
                icon: 'success',
                title: t,
                position: 'top-end',
                showConfirmButton: false,
                timer: 1500
            })
        }

        static showErrorAlert(t) {
            Swal.fire({
                icon: 'error',
                title: 'Warning',
                text: t,
            })
        }
    }

    static IziToast = class  {
        static showErrorAlert(m) {
            iziToast.error({
                title: 'Error',
                message: m,
            });
        }

        static showSuccessAlert(m) {
            iziToast.success({
                timeout: 5000,
                icon: 'success',
                title: 'OK',
                message: m,
            });
        }
    }

    static formatNumber() {
        $(".num-space").number(true, 0, ',', ' ');
        $(".num-point").number(true, 0, ',', '.');
        $(".num-comma").number(true, 0, ',', ',');
    }

    static formatNumberSpace(x) {
        if (x == null) {
            return x;
        }
        return x.toString().replace(/ /g, "").replace(/\B(?=(\d{3})+(?!\d))/g, " ");
    }
}

class Book {
    constructor(id, name, author, genre, publisher, quantity, available, active) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.quantity = quantity;
        this.available = available;
        this.active = active;
    }
}

class Type {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

class Author extends Type{
    constructor(id, name) {
        super();
    }
}

class Genre extends Type{
    constructor(id, name) {
        super();
    }
}

class Publisher extends Type{
    constructor(id, name) {
        super();
    }
}
