const express = require("express");
const cors = require("cors");
const bodyParser = require("body-parser");

const app = express();
app.use(cors());
app.use(bodyParser.json());


app.post("/detect", (req, res) => {
  const { username, bio } = req.body;
  const isFake = username.toLowerCase().includes("bot") || (bio && bio.length < 10);
  res.json({ isFake });
});


const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Backend running on port ${PORT}`);
});