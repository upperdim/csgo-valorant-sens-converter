let csgoDpi = document.getElementById('csgoDpi');    
let csgoSens = document.getElementById('csgoSens');
let valoDpi = document.getElementById('valoDpi');
let valoSens = document.getElementById('valoSens');

let csgoDpiMsg = document.getElementById('csgoDpiMsg');
let csgoSensMsg = document.getElementById('csgoSensMsg');
let valoDpiMsg = document.getElementById('valoDpiMsg');
let valoSensMsg = document.getElementById('valoSensMsg');

function isValid(input) {
    return input !== null && input.value !== '' && Number(input.value) > 0;
}

function csgo2valo() {
    let canContinue = true;

    if (!isValid(csgoDpi)) {
        csgoDpiMsg.innerHTML = "You must enter a positive number as CS:GO DPI for this operation.";
        canContinue = false;
    } else {
        csgoDpiMsg.innerHTML = "";
    }

    if (!isValid(csgoSens)) {
        csgoSensMsg.innerHTML = "You must enter a positive number as CS:GO sensitivity for this operation.";
        canContinue = false;
    } else {
        csgoSensMsg.innerHTML = "";
    }

    if (!isValid(valoDpi)) {
        valoDpiMsg.innerHTML = "You must enter a positive number as Valorant DPI for this operation.";
        canContinue = false;
    } else {
        valoDpiMsg.innerHTML = "";
    }

    valoSensMsg.innerHTML = "";

    if (!canContinue)
        return;

    let _csgoDpi = Number(csgoDpi.value);
    let _csgoSens = Number(csgoSens.value);
    let _valoDpi = Number(valoDpi.value);

    let _valoSens = (_csgoSens / 3.18) * (_csgoDpi / _valoDpi)
    valoSens.value = _valoSens.toFixed(6).toString();
}

function valo2csgo() {
    let canContinue = true;

    if (!isValid(csgoDpi)) {
        csgoDpiMsg.innerHTML = "You must enter a positive number as CS:GO DPI for this operation.";
        canContinue = false;
    } else {
        csgoDpiMsg.innerHTML = "";
    }

    if (!isValid(valoSens)) {
        valoSensMsg.innerHTML = "You must enter a positive number as Valorant sensitivity for this operation.";
        canContinue = false;
    } else {
        valoSensMsg.innerHTML = "";
    }

    if (!isValid(valoDpi)) {
        valoDpiMsg.innerHTML = "You must enter a positive number as Valorant DPI for this operation.";
        canContinue = false;
    } else {
        valoDpiMsg.innerHTML = "";
    }

    csgoSensMsg.innerHTML = "";

    if (!canContinue)
        return;

    let _csgoDpi = Number(csgoDpi.value);
    let _valoSens = Number(valoSens.value);
    let _valoDpi = Number(valoDpi.value);

    let _csgoSens = (_valoSens * 3.18) * (_valoDpi / _csgoDpi);
    csgoSens.value = _csgoSens.toFixed(6).toString();
}
