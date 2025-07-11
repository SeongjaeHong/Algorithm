/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  let word = '';
  let longest = 0;

  [...s].forEach((c) => {
    if (!word.includes(c)) {
      word = word.concat(c);
    } else {
      longest = longest < word.length ? word.length : longest;
      word = word.split(c)[1].concat(c);
    }
  });
  return longest < word.length ? word.length : longest;
};
