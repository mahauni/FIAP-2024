package visao

import modelo.Tabuleiro
import modelo.TabuleiroEvento
import java.awt.Image
import java.awt.Toolkit
import javax.swing.Icon
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

fun main(args: Array<String>) {
    TelaPrincipal()
}

class TelaPrincipal : JFrame() {
    // Modifiquei a quantidade de bombas, linhas e colunas para ter mais coisas
    private val tabuleiro = Tabuleiro(qtdeLinhas = 20, qtdeColunas = 40, qtdeMinas = 1)
    private val painelTabuleiro = PainelTabuleiro(tabuleiro)


    init {
        tabuleiro.onEvento(this::mostrarResultado)
        add(painelTabuleiro)

        // Aqui eu mudei o tamanho da tela para ficar com os blocos maiores
        setSize(990, 638)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        // Mudei o titulo do campo minado
        title = "Entrando em Bota Fogo"
        isVisible = true

        // criando o icone da imagem
        val icon = ImageIcon("src/img/gato_rindo.png")
        // setando a imagem do jframe
        iconImage = icon.image
    }

    private fun mostrarResultado(evento: TabuleiroEvento) {
        SwingUtilities.invokeLater {
            // Aqui mudei a mensagem de vitoria e derrota
            val msg = when(evento) {
                TabuleiroEvento.VITORIA -> "Você conseguiu ver um jogo do Vasco!"
                TabuleiroEvento.DERROTA -> "Imagina ser tão ruim :P"
            }

            // Aqui fica a imagem quando você é derrotado ou é vitorioso
            val icon = when(evento) {
                TabuleiroEvento.VITORIA -> ImageIcon("src/img/elisia_chibi.png")
                TabuleiroEvento.DERROTA -> ImageIcon("src/img/elysia_trunk.png")
            }

            // Aqui coloquei para que seja possivel adicionar a imagem no campo quando
            // você perde ou ganha
            JOptionPane.showMessageDialog(this, msg, "Mensagem", JOptionPane.PLAIN_MESSAGE, icon)

            tabuleiro.reiniciar()

            painelTabuleiro.repaint()
            painelTabuleiro.validate()
        }
    }
}
