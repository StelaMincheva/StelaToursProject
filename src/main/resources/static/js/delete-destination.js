const csrfHeaderName = document.head.querySelector('[name="_csrf_header"]').content;
const csrfHeaderValue = document.head.querySelector('[name="_csrf"]').content;

document.querySelectorAll('.delete-btn').forEach(button => {
    button.addEventListener('click', function (event) {

        const form = this.closest('form');
        const destinationId = form.querySelector('input[name="id"]').value;

        fetch(`/api/destinations/?id=` + destinationId,
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
                    console.log('The destination has been deleted!');

                } else {
                    console.error('Error deleting destination!');
                }
            })
            .catch(error => {
                console.error('Error executing the request: ' + error);
            });
    });
});

