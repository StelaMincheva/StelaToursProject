const csrfHeaderName = document.head.querySelector('[name="_csrf_header"]').content;
const csrfHeaderValue = document.head.querySelector('[name="_csrf"]').content;

document.querySelectorAll('.delete-seasonal-btn').forEach(btn => {
    btn.addEventListener('click', function (event) {

        const form = this.closest('form');
        const seasonalDestinationId = form.querySelector('input[name="id"]').value;

        fetch(`/api/?id=` + seasonalDestinationId,
            {
                method: "GET",
                headers: {
                    [csrfHeaderName]: csrfHeaderValue,
                    "Content-Type": "application/json",
                    "Accept": "application/json"
                },
                redirect: "follow"
            })
            .then(response => {
                if (response.ok) {
                    console.log('The seasonal destination has been deleted!');

                } else {
                    console.error('Error deleting seasonal destination!');
                }
            })
            .catch(error => {
                console.error('Error executing the request: ' + error);
            });
    });
});

