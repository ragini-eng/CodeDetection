const express = require('express');
const app = express();

// middleware
app.use(express.json());

// test endpoint
app.get('/', (req, res) => {
  res.send('Backend is alive');
});

// real endpoint
app.post('/detect', (req, res) => {
  const profile = req.body;
  // dummy logic for now
  const result = {
    score: 42,
    result: 'Likely Fake'
  };
  res.json(result);
});

// Make sure it's binding to 0.0.0.0
app.listen(3000, '0.0.0.0', () => {
  console.log("Server running on port 3000");
});
