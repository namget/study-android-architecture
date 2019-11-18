package com.namget.myarchitecture.di

import java.lang.annotation.Documented
import javax.inject.Scope

/**
 * Created by Namget on 2019.11.18.
 */
/**
 * In Dagger, an unscoped component cannot depend on a scoped component. As
 * [AppComponent] is a scoped component (`@Singleton`, we create a custom
 * scope to be used by all fragment components. Additionally, a component with a specific scope
 * cannot have a sub component with the same scope.
 */
//스코프가 되지 않은 컴포넌트는 스코프된 컴포넌트에 의존을 못한다.
@Documented
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScoped