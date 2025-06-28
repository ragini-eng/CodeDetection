function detectFake(profile) {
  let score = 0;

  const username = profile.username || "";
  const bio = profile.bio || "";

  
  if (/\d{4,}/.test(username)) score += 2;  // 4+ digits
  if (/([a-zA-Z])\1{2,}/.test(username)) score += 2; // repeated characters
  if (/[^a-zA-Z0-9]/.test(username)) score += 2; // special symbols
  if (username.toLowerCase().includes("official") && !profile.verified) score += 2;

  const spamWords = ["click", "follow back", "link in bio", "dm now", "free", "promo", "💰"];
  if (spamWords.some(w => bio.toLowerCase().includes(w))) score += 3;
  if ((bio.match(/https?:\/\//g) || []).length > 0) score += 2; // links
  if ((bio.match(/#[a-zA-Z0-9]+/g) || []).length > 3) score += 1; // hashtags
  if (bio === bio.toUpperCase() && bio.length > 10) score += 1; // ALL CAPS

  const emojiCount = [...bio].filter(c => /\p{Emoji}/u.test(c)).length;
  if (emojiCount > 4) score += 2;

  if (!profile.has_profile_pic || profile.profile_pic_name === "default.jpg") score += 3;


  if (profile.first_post_after_days !== undefined && profile.first_post_after_days < 1) score += 2;
  if (profile.posts_with_same_text !== undefined && profile.posts_with_same_text > 2) score += 2;


  if (profile.followers < 50 && profile.following > 500) score += 3;
  if (profile.followers === 0 || profile.following === 0) score += 2;

  if (profile.account_age_days !== undefined && profile.account_age_days < 7) score += 2;

  if (profile.posts < 3) score += 2;

  
  if (profile.mutual_followers !== undefined && profile.mutual_followers < 3) score += 2;

  if (profile.device_flagged_as_suspicious === true) score += 3;
  if (profile.same_device_multiple_accounts === true) score += 2;

  let label = "Likely Real";
  if (score >= 10) label = " Likely Fake";
  else if (score >= 5) label = " Suspicious";

  return {
    score,
    label,
    details: "Scored using advanced rule-based logic"
  };
}

module.exports = detectFake;
