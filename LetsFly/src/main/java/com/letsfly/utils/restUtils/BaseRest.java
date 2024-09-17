package com.letsfly.utils.restUtils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.letsfly.dto.UserDto;

import jakarta.servlet.http.HttpSession;


public abstract class BaseRest<EntityClass extends EntityInterface<DtoClass>, IdEntityClass, DtoClass extends DtoInterface<EntityClass>> {

  @Autowired
  protected JpaRepository<EntityClass, IdEntityClass> rep;

  public BaseRest(JpaRepository<EntityClass, IdEntityClass> rep) {
    this.rep = rep;
  }

  @GetMapping("{id}")
  public DtoClass searchById(@PathVariable(name = "id") IdEntityClass id,HttpSession session){
    UserDto uD = (UserDto) session.getAttribute("userForm");
		if (uD == null){
    DtoClass dtoClass = null;
    return dtoClass;
    }
		if (uD.getIsadmin() > 0) {
    EntityClass entityClass = rep.findById(id).orElse(null);
    DtoClass dtoClass = entityClass.toDto();
    return dtoClass;} else {
    DtoClass dtoClass = null;
    return dtoClass;}
    }
  

  @PostMapping
  public String insert(@RequestBody DtoClass dto,HttpSession session) {
  UserDto uD = (UserDto) session.getAttribute("userForm");
	if (uD == null){
  return "NOT AUTHORIZED!";
  }
	if (uD.getIsadmin() > 0) {
   EntityClass entity = dto.toEntity();
   rep.save(entity);
   return "Inserted";} else {
    return "NOT AUTHORIZED!";}
  }

  @PutMapping
  public String update(@RequestBody DtoClass dto,HttpSession session) {
    UserDto uD = (UserDto) session.getAttribute("userForm");
    if (uD == null){
    return "NOT AUTHORIZED!";
    }
    if (uD.getIsadmin() > 0) {
    EntityClass entity = dto.toEntity();
    rep.save(entity);
    return "Updated";} else {
      return "NOT AUTHORIZED!";}
    }
  

  @DeleteMapping("{id}")
  public String delete(@PathVariable IdEntityClass id,HttpSession session) {
    UserDto uD = (UserDto) session.getAttribute("userForm");
    if (uD == null){
    return "NOT AUTHORIZED!";
    }
    if (uD.getIsadmin() > 0) {
    rep.deleteById(id);
    return "Deleted";} else {
      return "NOT AUTHORIZED!";}
    }
  
  @GetMapping("list")
  public List<DtoClass> list (HttpSession session) {
    UserDto uD = (UserDto) session.getAttribute("userForm");
    if (uD == null){
      List<DtoClass> listDtoClass = new ArrayList<>();
      return listDtoClass;
    }
    if (uD.getIsadmin() > 0) {
    List<EntityClass> listEntityClass = rep.findAll();
    List<DtoClass> listDtoClass = new ArrayList<>();
    for (EntityClass entity : listEntityClass) {
      listDtoClass.add(entity.toDto());
    }
    return listDtoClass;} else {
      List<DtoClass> listDtoClass = new ArrayList<>();
      return listDtoClass;}
    }
  }

