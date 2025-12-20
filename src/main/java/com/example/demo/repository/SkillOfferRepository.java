@Repository
public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {
    // This correctly traverses SkillOffer -> Skill -> id
    List<SkillOffer> findBySkillId(Long skillId);
}