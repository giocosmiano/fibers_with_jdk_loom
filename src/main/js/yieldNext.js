const generate = function*(factor) {
  console.log('you entered...');
  yield 1;
  
  console.log('and then next step');
  yield 2;
  
  console.log('and more...');
  yield 3 * factor;
  
  for(let i = 0; i < 3; i++) {
    yield i + 8;
  }
}

for(const value of generate(7)) {
  console.log(`In the loop ${value}`);
}