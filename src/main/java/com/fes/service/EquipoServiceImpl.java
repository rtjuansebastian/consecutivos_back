package com.fes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fes.dao.EquipoDao;
import com.fes.entity.Equipo;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	private EquipoDao equipoDao;

	@Override
	public Equipo find(int id) {

		Equipo equipo = equipoDao.find(id);
		return equipo;
	}

	@Override
	public boolean create(Equipo equipo) {

		if (equipoDao.exist(equipo.getNombre())) {
			return false;
		} else {
			equipoDao.create(equipo);
			return true;
		}
	}

	@Override
	public List<Equipo> read() {

		return equipoDao.read();
	}

	@Override
	public Equipo update(Equipo equipo) {

		return equipoDao.update(equipo);
	}

	@Override
	public void delete(int id) {

		equipoDao.delete(id);
	}

}
