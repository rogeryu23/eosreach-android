package com.memtrip.eosreach.app.account.vote.cast.producers

import com.memtrip.mxandroid.MxRenderAction
import com.memtrip.mxandroid.MxViewLayout
import com.memtrip.mxandroid.MxViewRenderer
import javax.inject.Inject

sealed class CastProducersVoteRenderAction : MxRenderAction {
    object Idle : CastProducersVoteRenderAction()
    object OnProgress : CastProducersVoteRenderAction()
    data class OnError(val message: String, val log: String) : CastProducersVoteRenderAction()
    data class OnSuccess(val blockProducerName: String) : CastProducersVoteRenderAction()
    object NavigateToBlockProducerList : CastProducersVoteRenderAction()
    data class ViewLog(val log: String) : CastProducersVoteRenderAction()
}

interface CastProducersVoteViewLayout : MxViewLayout {
    fun showProgress()
    fun showError(message: String, log: String)
    fun onSuccess()
    fun navigateToBlockProducerList()
    fun viewLog(log: String)
}

class CastProducersVoteViewRenderer @Inject internal constructor() : MxViewRenderer<CastProducersVoteViewLayout, CastProducersVoteViewState> {
    override fun layout(layout: CastProducersVoteViewLayout, state: CastProducersVoteViewState): Unit = when (state.view) {
        CastProducersVoteViewState.View.Idle -> {
        }
        CastProducersVoteViewState.View.OnProgress -> {
            layout.showProgress()
        }
        is CastProducersVoteViewState.View.OnError -> {
            layout.showError(state.view.message, state.view.log)
        }
        is CastProducersVoteViewState.View.OnSuccess -> {
            layout.onSuccess()
        }
        CastProducersVoteViewState.View.NavigateToBlockProducerList -> {
            layout.navigateToBlockProducerList()
        }
        is CastProducersVoteViewState.View.ViewLog -> {
            layout.viewLog(state.view.log)
        }
    }
}