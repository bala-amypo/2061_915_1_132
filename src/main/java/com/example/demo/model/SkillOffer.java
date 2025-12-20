// In SkillOffer.java
public void setSkill(Skill skill) { this.skillCategory = skill; }
public Skill getSkill() { return null; } // Return a Skill bridge object if needed

// In SkillRequest.java
public void setUrgencyLevel(String level) { this.requiredLevel = level; }
public void setActive(boolean active) { }
public boolean isActive() { return true; }