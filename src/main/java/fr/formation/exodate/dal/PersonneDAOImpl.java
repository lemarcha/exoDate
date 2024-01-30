package fr.formation.exodate.dal;

import fr.formation.exodate.bo.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PersonneDAOImpl implements PersonneDAO{
    RowMapper<Personne> rowMapper = (rs, i)->
            new Personne(rs.getInt("id_personne"),rs.getString("nom"),rs.getString("prenom"), rs.getDate("ddn").toLocalDate());

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public void ajouterPersonne(Personne personne) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("nom", personne.getNom());
        namedParameters.addValue("prenom", personne.getPrenom());
        namedParameters.addValue("ddn", personne.getDdn());

        jdbcTemplate.update("INSERT INTO PERSONNE (nom, prenom, ddn) VALUES (:nom,:prenom, :ddn)", namedParameters, keyHolder);

        if (keyHolder != null && keyHolder.getKey() != null) {
            personne.setIdPersonne(keyHolder.getKey().intValue());
        }

        // TODO : a supprimer
        System.out.println("insertion de "+ personne);

    }


    @Override
    public List<Personne> getAll() {
        return jdbcTemplate.query("SELECT id_personne, nom, prenom, ddn FROM PERSONNE", rowMapper);
    }

    @Override
    public List<Personne> compareDate() {
        return null;
    }


}
