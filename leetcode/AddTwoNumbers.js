//  Definition for singly-linked list.
function ListNode(val, next) {
  this.val = val === undefined ? 0 : val;
  this.next = next === undefined ? null : next;
}

var addTwoNumbers = function (l1, l2) {
  let bit = 0;
  let answer = new ListNode();
  let l3 = answer;

  do {
    l3.next = new ListNode((l1?.val ?? 0) + (l2?.val ?? 0) + bit);
    l3 = l3.next;
    if (l3.val >= 10) {
      l3.val -= 10;
      bit = 1;
    } else {
      bit = 0;
    }

    l1 = l1?.next;
    l2 = l2?.next;
  } while (l1 || l2);

  if (bit) {
    l3.next = new ListNode(1);
  }

  return answer.next;
};

function sample(arr) {
  let x = new ListNode(arr[0]);
  let y = x;

  for (let i = 1; i < arr.length; i++) {
    y.next = new ListNode(arr[i]);
    y = y.next;
  }

  return x;
}

function print(node) {
  let arr = [];
  do {
    arr.push(node.val);
    node = node.next;
  } while (node);
  return arr;
}

let l1 = [9, 9, 9, 9, 9, 9, 9];
let l2 = [9, 9, 9, 9];
l1 = sample(l1);
l2 = sample(l2);
let x = addTwoNumbers(l1, l2);
print(x);
