console.log("Script Loaded");

//change theme work
let currentTheme = getTheme();

//initial -->
document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//TODO:
function changeTheme() {
  // set to web Page

  changePageTheme(currentTheme, "");
  document.querySelector("html").classList.add(currentTheme);

  //set the listenter to change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  changeThemeButton.querySelector("span").textContent =
    currentTheme == "light" ? "Dark" : "Light";

  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    console.log("change Theme Button clicked");

    if (currentTheme === "dark") {
      // theme light
      currentTheme = "light";
    } else {
      // theme dark
      currentTheme = "dark";
    }

    changePageTheme(currentTheme, oldTheme);
  });
}

//set theme to localStorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme from localStorage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

//CHANGE CURRENT THEME PAGE
function changePageTheme(theme, oldTheme) {
  // updates in local storage
  setTheme(currentTheme);

  //remove the current theme
  if (oldTheme) {
    document.querySelector("html").classList.remove(oldTheme);
  }

  //set the current theme
  document.querySelector("html").classList.add(theme);

  //change the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
}
