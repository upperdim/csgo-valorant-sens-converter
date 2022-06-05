let darkMode = true;

function darkModeToggle() {
    if (darkMode) {
        document.body.style.backgroundColor = "#cccccc";
        document.body.style.color = "black";
    } else {
        document.body.style.backgroundColor = "#454385";
        document.body.style.color = "#eeeeee";
    }
    darkMode = !darkMode;
}
