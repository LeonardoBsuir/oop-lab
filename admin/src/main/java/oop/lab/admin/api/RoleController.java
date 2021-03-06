package oop.lab.admin.api;


import oop.lab.admin.service.RoleService;
import oop.lab.common.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/scouting/roles")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role findOne(@PathVariable Long id) {
        return roleService.findOne(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role save(@RequestBody @Valid Role role) {
        return roleService.save(role);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable Long id) {
        roleService.delete(id);
    }
}
