import { getRandomActor } from "./actressAPI.js";
import { getActorImage } from "./actressAPI.js";
import { getActorHints } from "./actressAPI.js";
import { initializeApp } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-app.js";
import {
  getFirestore,
  doc,
  collection,
  getDoc,
  setDoc,
  query,
  where,
  getDocs,
} from "https://www.gstatic.com/firebasejs/10.2.0/firebase-firestore.js";

const firebaseConfig = {
  apiKey: "AIzaSyCdwzD12cU_Hxp7odCqFbBIcNmqyaeXeUk",
  authDomain: "heckatron-a282f.firebaseapp.com",
  databaseURL:
    "https://heckatron-a282f-default-rtdb.europe-west1.firebasedatabase.app",
  projectId: "heckatron-a282f",
  storageBucket: "heckatron-a282f.appspot.com",
  messagingSenderId: "615664701372",
  appId: "1:615664701372:web:38d56d9062ef1b3a8fe5b9",
};

const rightacor = getRandomActor();

const actorImage = getActorImage(rightacor);

const actorHints = getActorHints(rightacor);

console.log(rightacor);

console.log(actorImage);

console.log(actorHints);

const answer = document.querySelector("#answer");

const app = initializeApp(firebaseConfig);

const db = getFirestore(app);

var userId = localStorage.getItem("user");

const start = document.querySelector("#start");
const name = document.querySelector("#name");
start.addEventListener("click", async () => {
  if (name.value != "") {
    document.querySelector(".chooseName").style.display = "none";
    document.querySelector(".box").style.display = "flex";

    setTimeout(() => {
      document.querySelector(".box").style.display = "none";
      document.querySelector(".game").style.display = "flex";
      document.querySelector("span").style.display = "flex";
      document.querySelector("h2").innerHTML = `Nickname: ${name.value}`;
    }, 3000);

    setTimeout(() => {
      document.querySelector(".hits").innerHTML = `Question 1: ${
        actorHints ? actorHints[0] : ""
      }`;
    }, 3000);
  } else {
    document.querySelector(".name").style.border = "1px solid red";
    document.querySelector(".name").placeholder = "Digite seu nome";
  }
});

const switchActor = document.querySelector("#switchActor");
const tryagain = document.querySelector(".tryagain");

let count = 0;

switchActor.addEventListener("click", async () => {
  if (answer.value == rightacor) {
    alert("Congratz! You got it!");
    document.querySelector("#right").style.display = "block";
    document.querySelector("#right").src = actorImage;

    if (userId != null) {
      const userDocRef = doc(db, "users", userId);
      const userDocSnap = await getDoc(userDocRef);
      var wins = userDocSnap.data().wins;
      var defeats = userDocSnap.data().defeats;
      await setDoc(
        doc(db, "users", userId),
        {
          wins: wins + 1,
          defeats: defeats,
        },
        { merge: true }
      );
      setTimeout(() => {
        window.location.href = "win.html";
      }, 2000);
    } else {
      setTimeout(() => {
        window.location.href = "win.html";
      }, 2000);
    }

    document.querySelector(".actressName");
  } else {
    count++;

    if (count >= 10) {
      alert("You lost! Back you go");

      if (userId != null) {
        const userDocRef = doc(db, "users", userId);
        const userDocSnap = await getDoc(userDocRef);
        var wins = userDocSnap.data().wins;
        var defeats = userDocSnap.data().defeats;
        await setDoc(
          doc(db, "users", userId),
          {
            wins: wins,
            defeats: defeats + 1,
          },
          { merge: true }
        );
        window.location.href = "mainPage.html";
      } else {
        window.location.href = "index.html";
      }
    } else {
      document.querySelector(".hits").innerHTML = `Question ${count + 1}: ${
        actorHints ? actorHints[count] : ""
      }`;
    }

    const actorElement = document.querySelector(".actor");
    let isRed = false;

    function toggleColor() {
      if (isRed) {
        actorElement.style.backgroundColor = "transparent";
        actorElement.style.boxShadow = "none";
        actorElement.style.border = "3px solid #c316e30d";
      } else {
        actorElement.style.border = "2px solid #b31a1aa1";
        actorElement.style.boxShadow = "inset -1px 0px 20px 6px red";
      }

      isRed = !isRed;
    }

    const blinkingInterval = setInterval(toggleColor, 500);

    isRed = !isRed;
  }
});
