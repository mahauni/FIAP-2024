package visao

import modelo.Tabuleiro
import modelo.TabuleiroEvento
import javax.swing.Icon
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

fun main(args: Array<String>) {
    TelaPrincipal()
}

class TelaPrincipal : JFrame() {
    private val tabuleiro = Tabuleiro(qtdeLinhas = 20, qtdeColunas = 40, qtdeMinas = 100)
    private val painelTabuleiro = PainelTabuleiro(tabuleiro)

    init {
        tabuleiro.onEvento(this::mostrarResultado)
        add(painelTabuleiro)

        setSize(990, 638)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        title = "Entrando em Bota Fogo"
        isVisible = true
    }

    private fun mostrarResultado(evento: TabuleiroEvento) {
        SwingUtilities.invokeLater {
            val msg = when(evento) {
                TabuleiroEvento.VITORIA -> "Você conseguiu ver um jogo do Vasco!"
                TabuleiroEvento.DERROTA -> "Imagina ser tão ruim :P"
            }

            val icon = when(evento) {
                TabuleiroEvento.VITORIA -> ImageIcon("src/img/elisia_chibi.png")
                TabuleiroEvento.DERROTA -> ImageIcon("src/img/elysia_trunk.png")
            }

            JOptionPane.showMessageDialog(this, msg, "Mensagem", JOptionPane.PLAIN_MESSAGE, icon)

            tabuleiro.reiniciar()

            painelTabuleiro.repaint()
            painelTabuleiro.validate()
        }
    }
}