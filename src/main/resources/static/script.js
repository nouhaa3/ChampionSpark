// Fonction pour gérer le changement de couleur de la navbar lors du défilement
window.addEventListener('scroll', function() {
    const navbar = document.querySelector('.navbar');
    
    // Si la page est défilée de plus de 50px, on ajoute la classe 'scrolled'
    if (window.scrollY > 50) {
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
});

window.addEventListener('scroll', function() {
    const footer = document.querySelector('footer');
    if (window.scrollY > 50) {
        footer.classList.add('scrolled'); // Ajouter la classe "scrolled" au footer
    } else {
        footer.classList.remove('scrolled'); // Retirer la classe "scrolled"
    }
});