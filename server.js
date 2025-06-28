const express = require('express');
const bodyParser = require('body-parser');
const detectFake = require('./detectLogic');

const app = express();
app.use(bodyParser.json());

app.post('/detect', (req, res) => {
  const profile = req.body;
  const result = detectFake(profile);
  res.json(result);
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
