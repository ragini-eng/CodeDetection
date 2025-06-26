const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(bodyParser.json());

app.post('/detect', (req, res) => {
  const { username, followers, following, bio, profilePic } = req.body;
  let score = 0;

  if (!bio) score += 1;
  if (!profilePic) score += 1;
  if (followers / (following || 1) < 0.2) score += 1;

  const isFake = score >= 2;
  res.json({ fake: isFake, score });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Fake account detector is running on port ${PORT}`);
});