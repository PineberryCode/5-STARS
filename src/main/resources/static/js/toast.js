
document.addEventListener("DOMContentLoaded", function () {
    var form = document.getElementById("formRecommendation");
    form.addEventListener("submit", function(e) {
        e.preventDefault();
        
        var toast = new bootstrap.Toast(document.querySelector('#liveToast'));
        var submitBtn = document.getElementById("submitBtn");
        submitBtn.disabled = true;
        fetch('/sendRecommendation', {
            method: 'POST',
            body: new FormData(form)
        })
        .then(response => response.json()
        .then(data => {
            switch (data.recommendationSent) {
                case 'Your Recommendation had been sent.':
                    toast.show();
                    break;
                default:
                    console.log('Unexpected Response', data);
            }
        }).catch(error => {
            console.error('Error:',error);
        }).finally(() => {
            submitBtn.disabled = false;
        }));
    });
});