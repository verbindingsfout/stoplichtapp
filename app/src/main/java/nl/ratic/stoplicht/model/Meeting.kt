package nl.ratic.stoplicht.model

data class Meeting(
    val name: String = "",
    val description: String = "",
    var meetingid: String = "",
    val userid: String = "",
    val votes: HashMap<String, Vote> = hashMapOf(),
    var simpleDate: SimpleDate = SimpleDate()
) {
    fun getVoteCount() : VoteCount{
        val voteCount = VoteCount(0f,0f,0f)
        votes.values.forEach {
            when (it) {
                Vote.GREEN -> voteCount.green++
                Vote.ORANGE -> voteCount.orange++
                Vote.RED -> voteCount.red++
            }
        }
        return voteCount
    }
}