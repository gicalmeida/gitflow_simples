package br.edu.ifsp.bra.poliscientia.Model;

public class Pontuacao {
    private int questoesCertas;
    private int questoesErradas;

    /*@Entity
public class Pontuacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idAluno;
    private int idFase;
    private int pontuacao;

    // Getters e Setters
}
    @Repository
public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long> {
    Optional<Pontuacao> findByIdAlunoAndIdFase(Long idAluno, int idFase);
}

 */
}
