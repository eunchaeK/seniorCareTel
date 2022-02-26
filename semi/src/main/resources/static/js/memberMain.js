const slides = document.querySelector('.slides');
const slide = document.querySelectorAll('.slides li');
const preBtn = document.querySelector('.prev');
const nextBtn = document.querySelector('.next');
const dogImg = document.querySelector('li > img');
const lastChild = document.querySelector('.slides li:last-child');
const firstChild = document.querySelector('.slides li:first-child');
let currentIndex = 0;
let slideCount = slide.length;
let slideWidth = 1000;
let slideMargin = 70;
let left = window.outerWidth / 2 - slideWidth / 2 + 'px';
let outerWidth = window.outerWidth;

console.log(left);

slides.style.width =
  (slideWidth + slideMargin) * slideCount - slideMargin + 2 * outerWidth + 'px';

lastChild.style.marginRight = outerWidth / 2 - slideWidth / 2 + 'px';
//firstChild.style.marginLeft = outerWidth / 2 - slideWidth / 2 + 'px';

function moveSlide(num) {
  slides.style.left = -num * (slideWidth + slideMargin) + 'px';
  currentIndex = num;
}

nextBtn.addEventListener('click', function () {
  if (currentIndex < slideCount - 1) {
    moveSlide(currentIndex + 1);
  } else {
    moveSlide(0);
  }
});

preBtn.addEventListener('click', function () {
  if (currentIndex > 0) {
    moveSlide(currentIndex - 1);
  } else {
    moveSlide(slideCount - 1);
  }
});
