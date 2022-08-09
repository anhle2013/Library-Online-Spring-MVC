class App_card{
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

class CallCardDetail {
    constructor(id, callCardId, bookId, quantity, takenDate, maturityDate, returnDate, borrowStatus) {
        this.id = id;
        this.callCardId = callCardId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.takenDate = takenDate;
        this.maturityDate = maturityDate;
        this.returnDate = returnDate;
        this.borrowStatus = borrowStatus;
    }
}