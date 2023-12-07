let genes = [];

function addGene() {
    let geneInput = document.getElementById('geneInput');
    let geneList = document.getElementById('geneList');

    if (geneInput.value !== '') {
        genes.push(geneInput.value);
        geneInput.value = '';
        showGenes();
    }
}

function showGenes() {
    let geneList = document.getElementById('geneList');
    geneList.innerHTML = '';

    for (let i = 0; i < genes.length; i++) {
        let newGene = document.createElement('li');
        newGene.textContent = genes[i];
        geneList.appendChild(newGene);
    }
}