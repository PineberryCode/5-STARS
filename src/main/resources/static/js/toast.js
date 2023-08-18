
document.addEventListener("DOMContentLoaded", function () {
    var forms = document.querySelectorAll(".form");
    
    forms.forEach(form => {
        form.addEventListener("submit", function(e) {
            e.preventDefault();
            
            var toast = new bootstrap.Toast(document.querySelector('#liveToast'));
            var submitBtn = document.querySelector(".submitBtn");
            submitBtn.disabled = true;
    
            var urls = ['/global/contactUs/sendConsultation','/global/contactUs/sendRecommendation','/global/contactUs/sendComplaint'];
    
            Promise.all(urls.map(url =>
                fetch(url, {
                    method: 'POST',
                    body: new FormData(form)
                }).then(response => response.json())
            ))
            .then(responses => {
                responses.forEach(data => {
                    switch (data.resultMessage) {
                        case 'Your Recommendation had been sent.':
                            toast.show();
                            console.log(data);
                            break;
                        case 'Your Complaints had been sent.':
                            toast.show();
                            console.log(data);
                            break;
                        case 'Your consultation had been sent!':
                            toast.show();
                            console.log(data);
                            break;
                        default:
                            console.log('Unexpected Response', data);
                    }
                });
                
            })
            .catch(error => {
                console.error('Error:',error);
            })
            .finally(() => {
                submitBtn.disabled = false;
            });
        });
    });
});