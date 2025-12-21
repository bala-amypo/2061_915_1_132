@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService service;
    public SkillController(SkillService service) { this.service = service; }

    @GetMapping("/")
    public List<Skill> list() { return service.getAllSkills(); }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill skill) { return service.updateSkill(id, skill); }
}